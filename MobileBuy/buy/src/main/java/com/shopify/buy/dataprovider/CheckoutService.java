/*
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2015 Shopify Inc.
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package com.shopify.buy.dataprovider;

import com.shopify.buy.model.Checkout;
import com.shopify.buy.model.CreditCard;
import com.shopify.buy.model.GiftCard;
import com.shopify.buy.model.PaymentToken;
import com.shopify.buy.model.ShippingRate;

import java.util.List;

import rx.Observable;

/**
 * Service that provides Checkout API endpoints.
 */
public interface CheckoutService {

    /**
     * Initiate the Shopify checkout process with a new Checkout object.
     *
     * @param checkout the {@link Checkout} object to use for initiating the checkout process, not null
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask createCheckout(Checkout checkout, Callback<Checkout> callback);

    /**
     * Initiate the Shopify checkout process with a new Checkout object.
     *
     * @param checkout the {@link Checkout} object to use for initiating the checkout process, not null
     * @return cold observable that emits created checkout object
     */
    Observable<Checkout> createCheckout(Checkout checkout);

    /**
     * Update an existing Checkout's attributes.
     *
     * Only the following attributes will be updated, any others will be ignored:
     * <ul>
     * <li>{@link Checkout#email}</li>
     * <li>{@link Checkout#shippingAddress}</li>
     * <li>{@link Checkout#billingAddress}</li>
     * <li>{@link Checkout#lineItems}</li>
     * <li>{@link Checkout#discount}</li>
     * <li>{@link Checkout#shippingRate}</li>
     * <li>{@link Checkout#reservationTime}</li>
     * </ul>
     *
     * @param checkout the {@link Checkout} attributes to be updated, not null
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask updateCheckout(Checkout checkout, Callback<Checkout> callback);

    /**
     * Update an existing Checkout's attributes
     *
     * Only the following attributes will be updated, any others will be ignored:
     * <ul>
     * <li>{@link Checkout#email}</li>
     * <li>{@link Checkout#shippingAddress}</li>
     * <li>{@link Checkout#billingAddress}</li>
     * <li>{@link Checkout#lineItems}</li>
     * <li>{@link Checkout#discount}</li>
     * <li>{@link Checkout#shippingRate}</li>
     * <li>{@link Checkout#reservationTime}</li>
     * </ul>
     *
     * @param checkout the {@link Checkout} to update, not null
     * @return cold observable that emits updated checkout object
     */
    Observable<Checkout> updateCheckout(Checkout checkout);

    /**
     * Complete the checkout and process the payment session
     *
     * @param paymentToken  a {@link PaymentToken} associated with the checkout to be completed, not null if {@link Checkout#getPaymentDue()} is greater than 0
     * @param checkoutToken checkout token associated with the specified payment token, not null or empty
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask completeCheckout(PaymentToken paymentToken, String checkoutToken, Callback<Checkout> callback);

    /**
     * Complete the checkout and process the payment session
     *
     * @param paymentToken a {@link PaymentToken} associated with the checkout to be completed, not null if {@link Checkout#getPaymentDue()} is greater than 0
     * @param checkoutToken checkout token associated with the specified payment token, not null or empty
     * @return cold observable that emits completed checkout
     */
    Observable<Checkout> completeCheckout(PaymentToken paymentToken, String checkoutToken);

    /**
     * Get the status of the payment session associated with {@code checkout}. {@code callback} will be
     * called with a boolean value indicating whether the session has completed or not.
     *
     * @param checkoutToken checkout token for the {@link Checkout} to get the completion status for, not null or empty
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancellable task
     */
    CancellableTask getCheckoutCompletionStatus(String checkoutToken, final Callback<Boolean> callback);

    /**
     * Get the status of the payment session associated with {@code checkout}. {@code callback} will be
     * called with a boolean value indicating whether the session has completed or not.
     *
     * @param checkoutToken checkout token for the {@link Checkout} to get the completion status for, not null or empty
     * @return cold observable that emits a Boolean that indicates whether the checkout has been completed
     *
     */
    Observable<Boolean> getCheckoutCompletionStatus(String checkoutToken);

    /**
     * Fetch an existing Checkout from Shopify
     *
     * @param checkoutToken the token associated with the existing {@link Checkout}, not null or empty
     * @param callback      the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask getCheckout(String checkoutToken, Callback<Checkout> callback);

    /**
     * Fetch an existing Checkout from Shopify
     *
     * @param checkoutToken the token associated with the existing {@link Checkout}, not null or empty
     * @return cold observable that emits requested existing checkout
     */
    Observable<Checkout> getCheckout(String checkoutToken);

    /**
     * Fetch shipping rates for a given Checkout
     *
     * @param checkoutToken the {@link Checkout#token} from an existing Checkout, not null or empty
     * @param callback      the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask getShippingRates(String checkoutToken, Callback<List<ShippingRate>> callback);

    /**
     * Fetch shipping rates for a given Checkout
     *
     * @param checkoutToken the {@link Checkout#token} from an existing Checkout, not null or empty
     * @return cold observable that emits requested list of shipping rates for a given checkout
     */
    Observable<List<ShippingRate>> getShippingRates(String checkoutToken);

    /**
     * Post a credit card to Shopify's card server and associate it with a Checkout
     *
     * @param card     the {@link CreditCard} to associate, not null
     * @param checkout  the {@link Checkout} to associate the card with, not null
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask storeCreditCard(CreditCard card, Checkout checkout, Callback<PaymentToken> callback);

    /**
     * Post a credit card to Shopify's card server and associate it with a Checkout
     *
     * @param card     the {@link CreditCard} to associate, not null
     * @param checkout  the {@link Checkout} to associate the card with, not null
     * @return cold observable that emits payment token associated with specified checkout and credit card
     */
    Observable<PaymentToken> storeCreditCard(CreditCard card, Checkout checkout);

    /**
     * Apply a gift card to a Checkout
     *
     * @param giftCardCode the gift card code for a gift card associated with the current Shop, not null
     * @param checkout     the {@link Checkout} object to apply the gift card to, not null
     * @param callback     the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask applyGiftCard(String giftCardCode, Checkout checkout, Callback<Checkout> callback);

    /**
     * Apply a gift card to a Checkout
     *
     * @param giftCardCode the gift card code for a gift card associated with the current Shop, not null or empty
     * @param checkout     the {@link Checkout} object to apply the gift card to, not null
     * @return cold observable that emits updated checkout
     */
    Observable<Checkout> applyGiftCard(String giftCardCode, Checkout checkout);

    /**
     * Remove a gift card that was previously applied to a Checkout
     *
     * @param giftCardId the id of the {@link GiftCard} to remove from the {@link Checkout}, not null
     * @param checkout the {@code Checkout} to remove the {@code GiftCard} from, not null
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask removeGiftCard(Long giftCardId, Checkout checkout, Callback<Checkout> callback);

    /**
     * Remove a gift card that was previously applied to a Checkout
     *
     * @param giftCardId the id of the {@link GiftCard} to remove from the {@link Checkout}, not null
     * @param checkout the {@code Checkout} to remove the {@code GiftCard} from, not null
     * @return cold observable that emits updated checkout
     */
    Observable<Checkout> removeGiftCard(Long giftCardId, Checkout checkout);

    /**
     * Release all product inventory reservations associated with the checkout by setting the `reservationTime` of the checkout to `0` and calling {@link #updateCheckout(Checkout, Callback) updateCheckout(Checkout, Callback)}.
     * We recommend creating a new `Checkout` object from a `Cart` for further API calls.
     *
     * @param checkoutToken the token for the {@link Checkout} to expire, not null or empty
     * @param callback the {@link Callback} that will be used to indicate the response from the asynchronous network operation, not null
     * @return cancelable task
     */
    CancellableTask removeProductReservationsFromCheckout(String checkoutToken, Callback<Checkout> callback);

    /**
     * Release all product inventory reservations associated with the checkout by setting the `reservationTime` of the checkout to `0` and calling {@link #updateCheckout(Checkout, Callback) updateCheckout(Checkout, Callback)}.
     * We recommend creating a new `Checkout` object from a `Cart` for further API calls.
     *
     * @param checkoutToken the {@link Checkout} to expire, not null or empty
     * @return cold observable that emits updated checkout
     */
    Observable<Checkout> removeProductReservationsFromCheckout(String checkoutToken);
}
