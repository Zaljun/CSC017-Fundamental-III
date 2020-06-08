import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

//import myStock.stockInfo;
import yahoofinance.*;

public class myStock {

    // TODO: declare the data structures that store the stock info as the database here
	// HINT: you may consider to use HashMap which provides fast retrieval
	//       it can be declared as: HashMap<String, stockInfo>
	// HINT: you may also consider to use TreeSet which allows key-value pairs to be sorted by value 
	//       it can be declared as: TreeSet<Map.Entry<String, stockInfo>> so that we can easily return top k stocks with type of Map.Entry<String, stockInfo>
	// HINT: you're allowed to use more than one data structures, each of which holds the same data and serve for different purposes.

	// This is the nested class provided for you to store the information associated with a stock symbol
	
	private HashMap<String, stockInfo> info_hash;
	private TreeSet<Map.Entry<String, stockInfo>> info_tree;
	
	private static class stockInfo implements Comparable<stockInfo>{
		private String name;
		private BigDecimal price;
		public stockInfo(String nameIn, BigDecimal priceIn) {
			name = nameIn;
			price = priceIn;
		}
		// add copy constructor
		public stockInfo(stockInfo info) {
			name = info.name;
			price = info.price;
		}
		public String toString() {
			StringBuilder stockInfoString = new StringBuilder("");
			stockInfoString.append(name + " " + price.toString());
			return stockInfoString.toString();
		}
		
		@Override                                           // override comparable in stockInfo class for building BST by stockInfo(value)
		public int compareTo(stockInfo b) {
			// TODO Auto-generated method stub
			int r = this.price.compareTo(b.price);
			return r;	
		}
	}
	
	
	
	public myStock () {
		// TODO: implement the constructor to create the database
		// HINT: you need to create the data structures used for the database here,
		//		 and override the data structure's compare method if needed
		//       such that the stocks would be sorted by price in the data structure
		info_hash = new HashMap<>(500);
		info_tree = new TreeSet<Map.Entry<String, stockInfo>>(new Comparator<Map.Entry<String, stockInfo>>(){
			@Override
			public int compare(Map.Entry<String, stockInfo> e1, Map.Entry<String, stockInfo> e2) {       // reverse the oder from 
				return -1*e1.getValue().compareTo(e2.getValue());                                        // increasing to decreasing for top(k)
			}
		});
		

	}
    
	public void insertOrUpdate(String symbol, stockInfo stock) {
		// TODO: implement this method which is used to initialize and update the database
		// HINT: make sure the time complexity is at least O(log(n))   
		// HINT: if you use multiple data structures, make sure all of them are updated
		info_hash.put(symbol, stock);
		Map.Entry<String, stockInfo> entr = new Map.Entry<String, stockInfo>() {

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return symbol;
			}

			@Override
			public stockInfo getValue() {
				// TODO Auto-generated method stub
				return stock;
			}

			@Override
			public stockInfo setValue(stockInfo value) {
				// TODO Auto-generated method stub
				return stock;
			}			
		};
		info_tree.add(entr);

	}
	
	public stockInfo get(String symbol) {
		// TODO: implement this method to quickly retrieve record from database
		// HINT: time complexity should be O(1) constant time 
		if(info_hash.containsKey(symbol)) {
			stockInfo value = new stockInfo(info_hash.get(symbol));
			// return a copy of extracted stockInfo
			return value;
		}
		return null;
	}
	
	public List<Map.Entry<String, stockInfo>> top(int k) {
		// TODO: implement this method to return the stock records with top k prices.
		// HINT: this retrieval should be done in O(k) 
		// HINT: you can use Iterator to retrieve items in the sorted order. For example, if you use TreeSet,
		//       the Iterator can be created like: 
		//			set = new TreeSet<Map.Entry<String, stockInfo>>;
		//			Iterator<Map.Entry<String, stockInfo>> setIterator = set.iterator();
		//		 more usages of iterator can be learned from: https://www.geeksforgeeks.org/treeset-iterator-method-in-java/
		List<Map.Entry<String, stockInfo>> topk;
		topk =  new ArrayList<Entry<String, stockInfo>>(k);
		Iterator<Map.Entry<String, stockInfo>> setIterator = info_tree.iterator();
		int i;
		for(i = 0; i < k; i++) {
			if(setIterator.hasNext()) {
				topk.add(setIterator.next());
			}
		}
		return topk;
	}
	

    public static void main(String[] args) throws IOException {   	
    	
    	// test the database creation based on the input file
    	myStock techStock = new myStock();
    	BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./data/US-Tech-Symbols.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] var = line.split(":");
				
				// YahooFinance API is used
				// make sure the lib files are included in the project build path
				Stock stock = YahooFinance.get(var[0]);
				
				// test the insertOrUpdate operation 
				// here we are initializing the database
				if(stock.getQuote().getPrice() != null) {
					techStock.insertOrUpdate(var[0], new stockInfo(var[1], stock.getQuote().getPrice())); 
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 1;
		System.out.println("===========Top 10 stocks===========");
		
		// test the top operation
		for (Map.Entry<String, stockInfo> element : techStock.top(10)) {
		    System.out.println("[" + i + "]" +element.getKey() + " " + element.getValue());
		    i++;
		}
		
		// test the get operation
		System.out.println("===========Stock info retrieval===========");
    	System.out.println("VMW" + " " + techStock.get("VMW"));
    	System.out.println("CHL" + " " + techStock.get("CHL"));
    	System.out.println("ABCD" + " "+ techStock.get("ABCD"));
    }
}