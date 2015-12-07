/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Shopify Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.shopify.buy.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Customer extends ShopifyObject {

    private String email;

    private String password;

    private String token;

    @SerializedName("accepts_marketing")
    private boolean acceptsMarketing;

    @SerializedName("created_at")
    private Date createdAtDate;

    @SerializedName("updated_at")
    private Date updatedAtDate;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("orders_count")
    private int ordersCount;

    private String state;

    @SerializedName("total_spent")
    private String totalSpent;

    private String note;

    @SerializedName("verified_email")
    private boolean verifiedEmail;

    @SerializedName("multipass_identifier")
    private String multipassIdenfier;

    @SerializedName("tax_exempt")
    private boolean taxExempt;

    private String tags;

    @SerializedName("last_order_id")
    private String lastOrderId;

    @SerializedName("last_order_name")
    private String lastOrderName;

    private List<Address> addresses;

    @SerializedName("default_address")
    private Address defaultAddress;

    /**
     * @return The access token for this Customer.
     */
    public String getToken() {
        return token;
    }

    /**
     * @return The email for this customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return {code true} if this customer accepts marketing.
     */
    public boolean acceptsMarketing() {
        return acceptsMarketing;
    }

    /**
     * @return The date this product was created.
     */
    public Date getCreatedAtDate() {
        return createdAtDate;
    }

    /**
     * @return The date this product was last updated.
     */
    public Date getUpdatedAtDate() {
        return updatedAtDate;
    }

    /**
     * @return The first name for this customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return The last name for this customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The number of orders this customer has.
     */
    public int getOrdersCount() {
        return ordersCount;
    }

    /**
     * @return The current state of this customer.
     */
    public String getState() {
        return state;
    }

    /**
     * @return The total amount of money that the customer has spent at the shop.
     */
    public String getTotalSpent() {
        return totalSpent;
    }

    /**
     * @return A note about the customer.
     */
    public String getNote() {
        return note;
    }

    /**
     * @return {code true} if the customer email address has been verified.
     */
    public boolean isVerifiedEmail() {
        return verifiedEmail;
    }

    /**
     * @return The customer's identifier used with Multipass login.
     */
    public String getMultipassIdenfier() {
        return multipassIdenfier;
    }

    /**
     * @return Indicates whether the customer should be charged taxes when placing orders. Valid values are {@code true} and {@code false}.
     **/
    public boolean isTaxExempt() {
        return taxExempt;
    }

    /**
     * @return A comma seperated list of tags which have been added to this customer.
     */
    public String getTags() {
        return tags;
    }

    /**
     * @return The id of the customer's last order.
     */
    public String getLastOrderId() {
        return lastOrderId;
    }

    /**
     * @return The name of the customer's last order. This is directly related to the Order's name field.
     */
    public String getLastOrderName() {
        return lastOrderName;
    }

    /**
     * @return A list of addresses for the customer.
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @return The default address for the customer.
     */
    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
