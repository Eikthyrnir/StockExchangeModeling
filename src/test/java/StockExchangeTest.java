import core.Stock;
import core.StockExchange.StockExchange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StockExchangeTest {

    private StockExchange stockExchange;

    @Before
    public void init() {
        this.stockExchange = new StockExchange(new HashMap<>() {
            {
                put(Stock.APPLE,    1000);
                put(Stock.EA,       1000);
                put(Stock.SUN,      1000);
                put(Stock.BLIZZARD, 1000);
                put(Stock.YANDEX,   1000);
            }
        });
    }


    @After
    public void endTest() {
        stockExchange = null;
    }


    @Test
    public void buyTest() {

    }


    @Test
    public void sellTest() {

    }
}
