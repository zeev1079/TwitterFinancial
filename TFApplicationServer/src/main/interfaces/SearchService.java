package main.interfaces;

import com.google.inject.Singleton;
import main.objects.Search;
import main.objects.Company;

import java.util.List;

@Singleton
public class SearchService implements SearchInterface {

    private final searchModel searchModel;

    public SearchService(SearchModel searchModel) {
        this.searchModel = searchModel;
    }

    public int requestIPCount(String ip) {
        return this.searchModel.requestIPCount(ip);
    }

    public Object requestTwitterInfo(String ticker) {
        return this.searchModel.requestTwitterInfo(ticker);
    }

    public Object requestStockInfo(String ticker) {
        return this.searchModel.requestStockInfo(ticker);
    }

    public Object doFavorite(Object company) {
        return this.searchModel.requestStockInfo(company);
    }

    public Object doSearch(String ticker) {
        return this.searchModel.doSearch(ticker);
    }

    public List getAllCompanyFavoriates(int userID) {
        return this.searchModel.doFavorite(userID);
    }
}
