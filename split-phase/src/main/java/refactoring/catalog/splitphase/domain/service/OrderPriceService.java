package refactoring.catalog.splitphase.domain.service;


import lombok.NonNull;
import refactoring.catalog.splitphase.domain.model.Product;
import refactoring.catalog.splitphase.domain.model.ShippingMethod;


public sealed interface OrderPriceService permits OrderPriceServiceImpl {
    int priceOrder(Product product, int quantity, ShippingMethod shippingMethod);
}


final class OrderPriceServiceImpl implements OrderPriceService {

    @Override
    public int priceOrder(@NonNull final Product product,
                          @NonNull final int quantity,
                          @NonNull final ShippingMethod shippingMethod) {

        final int basePrice = product.basePrice() * quantity;

        final int discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate() / 100;

        final int shippingPerCase = (basePrice > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();

        final int shippingCost = quantity * shippingPerCase;

        final int price = basePrice - discount + shippingCost;

        return price;
    }
}
