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

package com.shopify.sample.activity;

import android.os.Bundle;

import com.shopify.buy.ui.collections.CollectionListBuilder;
import com.shopify.buy.ui.common.BaseFragment;
import com.shopify.sample.BuildConfig;
import com.shopify.sample.R;

/**
 * The first activity in the app flow. Allows the user to browse the list of collections and drill down into a list of products.
 */
public class CollectionListActivity extends com.shopify.buy.ui.collections.CollectionListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.choose_collection);
    }

    @Override
    protected BaseFragment createFragment() {
        return new CollectionListBuilder()
                .setApiKey(BuildConfig.API_KEY)
                .setChannelId(BuildConfig.CHANNEL_ID)
                .setShopDomain(BuildConfig.SHOP_DOMAIN)
                .setApplicationName(getString(R.string.app_name))
                .setRoutingCoordinator(new SampleRoutingCoordinator())
                .buildFragment();
    }

}
