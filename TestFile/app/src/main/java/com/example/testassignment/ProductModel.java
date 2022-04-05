package com.example.testassignment;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class ProductModel implements Serializable{

    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("skip")
    @Expose
    private Integer skip;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductModel() {
    }

    /**
     *
     * @param total
     * @param limit
     * @param skip
     * @param products
     */
    public ProductModel(List<Product> products, Integer total, Integer skip, Integer limit) {
        super();
        this.products = products;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }




    public class Product  implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("discountPercentage")
        @Expose
        private Float discountPercentage;
        @SerializedName("rating")
        @Expose
        private Float rating;
        @SerializedName("stock")
        @Expose
        private Integer stock;
        @SerializedName("brand")
        @Expose
        private String brand;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("images")
        @Expose
        private List<String> images = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Product() {
        }

        /**
         *
         * @param discountPercentage
         * @param thumbnail
         * @param images
         * @param price
         * @param rating
         * @param description
         * @param id
         * @param title
         * @param stock
         * @param category
         * @param brand
         */
        public Product(Integer id, String title, String description, Integer price, Float discountPercentage, Float rating, Integer stock, String brand, String category, String thumbnail, List<String> images) {
            super();
            this.id = id;
            this.title = title;
            this.description = description;
            this.price = price;
            this.discountPercentage = discountPercentage;
            this.rating = rating;
            this.stock = stock;
            this.brand = brand;
            this.category = category;
            this.thumbnail = thumbnail;
            this.images = images;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Float getDiscountPercentage() {
            return discountPercentage;
        }

        public void setDiscountPercentage(Float discountPercentage) {
            this.discountPercentage = discountPercentage;
        }

        public Float getRating() {
            return rating;
        }

        public void setRating(Float rating) {
            this.rating = rating;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

    }

}