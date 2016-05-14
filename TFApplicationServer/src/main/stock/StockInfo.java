/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareEnginering;
import java.io.IOException;
import java.math.BigDecimal;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
/**
 *
 * @author Owner
 */
public class StockInfo
{

    public long getAverageV() {
        return AverageV;
    }

    public void setAverageV(long AverageV) {
        this.AverageV = AverageV;
    }

    public BigDecimal getDayHigh() {
        return DayHigh;
    }

    public void setDayHigh(BigDecimal DayHigh) {
        this.DayHigh = DayHigh;
    }

    public BigDecimal getDayLow() {
        return DayLow;
    }

    public void setDayLow(BigDecimal DayLow) {
        this.DayLow = DayLow;
    }

    public BigDecimal getESP() {
        return ESP;
    }

    public void setESP(BigDecimal ESP) {
        this.ESP = ESP;
    }

    public String getExchange() {
        return Exchange;
    }

    public void setExchange(String Exchange) {
        this.Exchange = Exchange;
    }

    public BigDecimal getMarketCap() {
        return MarketCap;
    }

    public void setMarketCap(BigDecimal MarketCap) {
        this.MarketCap = MarketCap;
    }

    public BigDecimal getOpen() {
        return Open;
    }

    public void setOpen(BigDecimal Open) {
        this.Open = Open;
    }

    public BigDecimal getPClosed() {
        return PClosed;
    }

    public void setPClosed(BigDecimal PClosed) {
        this.PClosed = PClosed;
    }

    public long getVolume() {
        return Volume;
    }

    public void setVolume(long Volume) {
        this.Volume = Volume;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {
        this.askPrice = askPrice;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public void setDividend(BigDecimal dividend) {
        this.dividend = dividend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrecentChange() {
        return precentChange;
    }

    public void setPrecentChange(BigDecimal precentChange) {
        this.precentChange = precentChange;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    private BigDecimal Open,PClosed,dividend, askPrice, bidPrice, precentChange, DayHigh, DayLow, revenue, ESP, MarketCap;
    private long AverageV,Volume;
    private Stock stock;
    private String ticker, name, Exchange;

    public StockInfo(String ticker) throws IOException
    {
        stock = YahooFinance.get(ticker);
        askPrice = stock.getQuote().getAsk();
        bidPrice = stock.getQuote().getBid();
        precentChange = stock.getQuote().getChangeInPercent();
        DayHigh =  stock.getQuote().getDayHigh();
        DayLow = stock.getQuote().getDayLow();
        Open = stock.getQuote().getOpen();
        PClosed = stock.getQuote().getPreviousClose();
        Volume = stock.getQuote().getVolume();
        AverageV = stock.getQuote().getAvgVolume();
        dividend = stock.getDividend().getAnnualYieldPercent();
        revenue = stock.getStats().getRevenue();
        ESP = stock.getStats().getEps();
        MarketCap = stock.getStats().getMarketCap();
        this.ticker = ticker;
        name = stock.getName();
        Exchange = stock.getStockExchange();
    }

    public void Print()
    {
        System.out.println("Ticker :"+getTicker()+" name: "+getName()+" Exchange Market: "+getExchange()+" Market CAP:"+getMarketCap());
        System.out.println("open price: "+getOpen()+" ask price: "+getAskPrice()+" bid price:"+getBidPrice()+" Precent Change:"+getPrecentChange());
        System.out.println("previous closed:"+getPClosed()+" Day High: "+getDayHigh()+" Day Low:"+getDayLow()+" dividend:"+getDividend());
        System.out.println("Estimated price:"+getESP()+" Volume:"+getVolume()+" Average Volume:"+getAverageV()+" Revenue:"+getRevenue());
    }

}
