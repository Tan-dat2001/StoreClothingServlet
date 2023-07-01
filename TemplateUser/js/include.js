class inHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="main-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="text-slid-box">
                            <div id="offer-box" class="carouselTicker">
                                <ul class="offer-box">
                                    <li>
                                        <i class="fab fa-opencart"></i> Chào mừng đến với D&L Clothing
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Mang lại cho bạn trải nghiệm tốt nhất
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Với các sản phẩm độc đáo
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Hãy thỏa sức khám phá
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Chào mừng đến với D&L Clothing
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Mang lại cho bạn trải nghiệm tốt nhất
                                    </li>
                                    <li>
                                        i class="fab fa-opencart"></i> Với các sản phẩm độc đáo
                                    </li>
                                    <li>
                                        <i class="fab fa-opencart"></i> Hãy thỏa sức khám phá
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="right-phone-box">
                            <p>Call US :- <a href="#"> +11 900 800 100</a></p>
                        </div>
                        <div class="our-link">
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Our location</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        `
    }
}
customElements.define('include-header', inHeader)


class inFooter extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        
        `
    }
}
customElements.define('include-footer', inFooter)