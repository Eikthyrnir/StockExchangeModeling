package core.StockExchange;

import core.Broker;
import core.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StockExchange {

    private Map<Broker, Map<Stock, AtomicInteger>> brokerStocks = new HashMap<>();
    private Map<Stock, StockInfo> allStocks = new HashMap<>();


    public StockExchange(Map<Stock, Integer> initStocks) {
        initStocks.forEach((k, v) -> allStocks.put(k, new core.StockExchange.StockInfo(v, v)));
    }


    public void sell(Stock stock, int amount, Broker broker) {
        AtomicInteger atomicAmount = new AtomicInteger(amount);

        brokerStocks.putIfAbsent(broker, new HashMap<>());
        brokerStocks.get(broker).putIfAbsent(stock, atomicAmount);

        allStocks.putIfAbsent(stock, new core.StockExchange.StockInfo(0, 0));
        allStocks.get(stock).add(broker, atomicAmount);
    }


    public boolean buy(Stock stock, int amount, Broker broker) {
        core.StockExchange.StockInfo stockInfo = allStocks.get(stock);
        if(stockInfo == null) {
            return false;
        }

        int stocksToBuy = Integer.min(amount, stockInfo.totalAmount);
        stockInfo.sub(stocksToBuy);
        broker.addStocks(stock, stocksToBuy);

        return true;
    }


    public void returnStocks(Broker broker) {

    }
}
