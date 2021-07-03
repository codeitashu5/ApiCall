package com.ashupandey.view.click.lisner.various.views.and.learnigapicall

data class DataItem(
        val `data`: List<Data>,
        val page: Int,
        val per_page: Int,
        val support: Support,
        val total: Int,
        val total_pages: Int
)