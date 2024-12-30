<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<div class="col-lg-3 col-md-5">
    <div class="sidebar">
        <div class="sidebar__item">
            <h4>Tất cả loại gạch</h4>
            <ul>
                <c:forEach items="${categoryList}" var="category">
                    <li><a style="cursor: pointer;" onclick="return searchByCategory(${category.id})">${category.name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <%--        <div class="sidebar__item">--%>
        <%--            <h4>Giá </h4>--%>
        <%--            <div class="price-range-wrap">--%>
        <%--                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"--%>
        <%--                     data-min="10" data-max="540">--%>
        <%--                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>--%>
        <%--                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>--%>
        <%--                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>--%>
        <%--                </div>--%>
        <%--                <div class="range-slider">--%>
        <%--                    <div class="price-input">--%>
        <%--                        <input type="text"  maxlength="13"  name="priceFrom" id="priceFrom">--%>
        <%--                        <input type="text"  maxlength="13" value="" name="priceTo" id="priceTo">--%>
        <%--                        <input type="button"--%>
        <%--                               onclick="return searchByPrice(document.getElementById('priceFrom').value,document.getElementById('priceTo').value)"--%>
        <%--                               class="filter-button-solid" style="background-color: #efac92;"--%>
        <%--                               value="ÁP DỤNG">--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <!--Lọc giá-->
        <div class="sidebar__item">
            <h4>Khoảng giá</h4>
            <div class="filter_products-price-range-input" style="">
                <input type="text" maxlength="13" class="filter-price-range-filter__input" placeholder="₫ TỪ" value=""
                       name="priceFrom" id="priceFrom" style="float: left;width: 150px;">
                <div class="filter-price-range-filter__range-line"></div>
                <input type="text" maxlength="13" class="filter-price-range-filter__input" placeholder="₫ ĐẾN" value=""
                       name="priceTo" id="priceTo" style=" width: 150px;margin-top: 10px;">
            </div>
            <input type="button"
                   onclick="return searchByPrice(document.getElementById('priceFrom').value,document.getElementById('priceTo').value)"
                   class="filter-button-solid"
                   style="background-color: #c43434;margin-top: 15px; color: white;border: none;border-radius: 2px;height: 35px;width: 150px;"
                   value="ÁP DỤNG">
        </div>
        <div class="sidebar__item">
            <h4>Kích thước</h4>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('10 x 60')"
                       class="brand-name">10x60</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('15 x 75')"
                       class="brand-name">15x75</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('100 x 100')"
                       class="brand-name">100x100</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('19 x 19')"
                       class="brand-name">19x19</label>
            </div>

            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('30 x 40')"
                       class="brand-name">30x40</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('30 x 60')"
                       class="brand-name">30x60</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('40 x 40')"
                       class="brand-name">40x40</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('40 x 80')"
                       class="brand-name">40x80</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('120 x 180')"
                       class="brand-name">120x180</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('60 x 90')"
                       class="brand-name">60x90</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('60 x 60')"
                       class="brand-name">60x60</label>
            </div>
            <div class="sidebar__item__size">
                <label style="cursor: pointer;" onclick="return searchBySize('80 x 80')"
                       class="brand-name">80x80</label>
            </div>
        </div>
        <div class="sidebar__item">
            <div class="latest-product__text">
                <h4>Sản phẩm mới</h4>
                <div class="latest-product__slider owl-carousel">
                    <div class="latest-prdouct__slider__item">
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-1.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch lát cầu thang 40x90</h6>
                                <span>300.000 VND</span>
                            </div>
                        </a>
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-2.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch con sâu lát vỉa hè</h6>
                                <span>165.000 VND</span>
                            </div>
                        </a>
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-3.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch ốp tường 30x60 Catalan</h6>
                                <span>200.000 VND</span>
                            </div>
                        </a>

                    </div>
                    <div class="latest-prdouct__slider__item">
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-1.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch lát cầu thang 40x90</h6>
                                <span>300.000 VND</span>
                            </div>
                        </a>
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-2.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch con sâu lát vỉa hè</h6>
                                <span>165.000 VND</span>
                            </div>
                        </a>
                        <a href="#" class="latest-product__item">
                            <div class="latest-product__item__pic">
                                <img src="${url}/img/latest-product/lp-3.jpg" alt="">
                            </div>
                            <div class="latest-product__item__text">
                                <h6>Gạch ốp tường 30x60 Catalan</h6>
                                <span>200.000 VND</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<script src="${url}/js/jquery.js"></script>--%>
