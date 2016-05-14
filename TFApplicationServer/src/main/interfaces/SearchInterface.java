package main.interfaces;

import java.util.List;

public interface SearchService {

    public String ticker;
	public Search searchObj;
	public int search_id;
	
	static String ip_address;
	static Object log;
	static Date search_reg_date;
	static int company_id;
	static String name;
	static Date company_reg_date;
	static boolean favorite_status;
	static int stock_info_id;
	static double net_income;
	static double net_margin;
	static double cash;
	static double stock_price;
	static double total_debt;
	static double trading_value;
	static double fcash_flow;
	static Object all_ratings;
	static Date stock_info_reg_date;
	static Date stock_last_updated;
	static int social_info_id;
	static int tweet_count;
	static boolean sentiment;
	static Date social_info_reg_date;
	static Date social_last_updated;
	
	public int requestIPCount(String ip);
	public Object requestTwitterInfo(String ticker);
	public Object requestStockInfo(String ticker);	
	public boolean doSearch(String ticker);
	public boolean doFavorite(Object company);	
	public List getAllCompanyFavoriates(id userID);
}
