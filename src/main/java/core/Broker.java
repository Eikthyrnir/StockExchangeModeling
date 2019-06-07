package core;

import core.StockExchange.StockExchange;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Broker extends Thread {

    private String name;
    private Map<Stock, AtomicInteger> stocks;
    private Set<StockExchange> stockExchanges;


    public Broker(String name, Map<Stock, Integer> stocks, Set<StockExchange> stockExchanges) {
        this.name = name;
        this.stocks = new HashMap<>();
        stocks.forEach((k, v)-> this.stocks.put(k, new AtomicInteger(v)));
        this.stockExchanges = stockExchanges;
    }

    public Broker(String name, Map<Stock, Integer> stocks) {
        this(name, stocks, new HashSet<>());
    }


    @Override
    public void run() {

    }

    public void addStocks(Stock stock, int amount) {
        stocks.putIfAbsent(stock, new AtomicInteger(0));
        stocks.get(stock).addAndGet(amount);
    }


    public void addStockExchange(StockExchange stockExchange) {
        stockExchanges.add(stockExchange);
    }


    public String getBrokerName() {
        return name;
    }

    public void setBrokerName(String name) {
        this.name = name;
    }
}
