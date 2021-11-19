package video3;

/*
    What tests should I be writing? Meaningful tests
    - Tests should be focused on outcomes from the requirements, not the details of your design
    - Beyond a little high-level design, let the tests elicit the design
    - Maps very well to user stories
    - Sometimes the implementation is obvious, no need to triangulate
    - If a leap leads to a failure, try taking smaller steps

    TDD by Example - Kent Beck
    - Create a test list
    - BDD, specification by example

    Requirements
    ------------
    Customers can buy CDs, searching on the title and artist.
    Record Labels send batches of CDs to the Warehouse.
    Customers can only order CDs that are in stock.

    Buying a CD
    - In stock, stock count is reduced
    - Insufficient stock, throw an exception
    Searching for a CD
    - In catalog, return match
    - Not in catalog, return nothing
    - Multiple in catalog, return list of matches
    Receiving Stock
    - Single title already in catalog, add copies received to stock
    - Single title not in catalog, add to catalog and add copies received to stock
    - Multiple titles, new CDs added to catalog, add copies received to stock
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CDWarehouseTest {

    @Test
    public void buyCDInStock() {
        CompactDisc cd = new CompactDisc(10);
        try {
            cd.buy(1);
        } catch (InsufficientStockException e) {
            fail("Unexpected exception thrown");
        }
        assertEquals(9, cd.getCurrentStock());
    }

    @Test
    public void buyCDNotInStock() {
        CompactDisc cd = new CompactDisc(0);
        assertThrows(InsufficientStockException.class, () -> cd.buy(1));
    }
}
