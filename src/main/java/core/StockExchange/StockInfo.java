package core.StockExchange;

import core.Auxiliary.Pair;
import core.Broker;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

class StockInfo {

    int totalAmount;
    int stockExchangeAmount;
    Map<Broker, AtomicInteger> sellingStocks = new HashMap<>();
    Queue<Pair<Broker, Integer>> brokerQueue = new ArrayDeque<>();


    StockInfo(int totalAmount, int stockExchangeAmount) {
        this.totalAmount         = totalAmount;
        this.stockExchangeAmount = stockExchangeAmount;
    }


    void add(Broker broker, AtomicInteger amount) {
        int intAmount = amount.intValue();
        totalAmount += intAmount;

        brokerQueue.add(Pair.makePair(broker, intAmount));

        if(sellingStocks.containsKey(broker)) {
            sellingStocks.get(broker).addAndGet(intAmount);
            return;
        }
        sellingStocks.put(broker, amount);
    }


    void sub(int amount) {
        totalAmount -= amount;

        while(amount > 0 && !brokerQueue.isEmpty()) {
            Pair<Broker, Integer> curr = brokerQueue.peek();
            if(amount > curr.second) {
                amount -= curr.second;
                curr.second = 0;
            } else {
                curr.second -= amount;
                amount = 0;
            }
            if(curr.second == 0) {
                brokerQueue.poll();
            }
        }

        stockExchangeAmount -= amount;
    }


    void sub(Broker broker, int amount) {
        totalAmount -= amount;
        sellingStocks.get(broker).addAndGet(-amount);
    }


    int balance(Broker broker) {
        return sellingStocks.get(broker).intValue();
    }
}
