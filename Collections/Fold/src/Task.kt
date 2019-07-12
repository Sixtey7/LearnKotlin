// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    var allProducts = customers.flatMap { it.orders }.flatMap { orders -> orders.products }.toSet();
    return customers.fold(allProducts,{
        commonElements, customer ->
            commonElements.intersect(customer.orders.flatMap{ it.products }.toSet());
    });
}
