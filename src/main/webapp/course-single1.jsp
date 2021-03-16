<%@include file="../language.jsp" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<head>
  <title><fmt:message key="header.title"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
  <link rel="stylesheet" href="fonts/icomoon/style.css">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">

  <link rel="stylesheet" href="css/jquery.fancybox.min.css">

  <link rel="stylesheet" href="css/bootstrap-datepicker.css">

  <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

  <link rel="stylesheet" href="css/aos.css">
  <link href="css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

  <link rel="stylesheet" href="css/style.css">



</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>


    <div class="py-2 bg-light">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-9 d-none d-lg-block">
            <a href="#" class="small mr-3"><span class="icon-question-circle-o mr-2"></span><fmt:message key="header.question"/></a> 
            <a href="#" class="small mr-3"><span class="icon-phone2 mr-2"></span><fmt:message key="header.phone"/></a> 
            <a href="#" class="small mr-3"><span class="icon-envelope-o mr-2"></span><fmt:message key="header.email"/></a> 
          </div>
          <div class="col-lg-3 text-right">
            <a href="Controller?command=gotologinpage" class="small mr-3"><span class="icon-unlock-alt"></span><fmt:message key="header.login"/></a>
            <a href="Controller?command=gotoregisterpage" class="small btn btn-primary px-4 py-2 rounded-0"><span class="icon-users"></span><fmt:message key="header.register"/></a>
          </div>
        </div>
      </div>
    </div>
    <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="d-flex align-items-center">
          <div class="site-logo">
            <a href="index.jsp" class="d-block">
              <img src="images/logo_bsuir.png" alt="Image" class="img-fluid">
            </a>
          </div>
          <div class="mr-auto">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li class="active">
                  <a href="index.jsp" class="nav-link text-left"><fmt:message key="header.home"/></a>
                </li>
                <li class="has-children">
                  <a href="about.jsp" class="nav-link text-left"><fmt:message key="header.about"/></a>
                  <ul class="dropdown">
                    <li><a href="about.jsp"><fmt:message key="header.university"/></a></li>
                  </ul>
                </li>
                <li>
                  <a href="courses.jsp" class="nav-link text-left"><fmt:message key="header.faculty"/></a>
                </li>
                <li>
                  <a href="contact.jsp" class="nav-link text-left"><fmt:message key="header.contact"/></a>
                </li>
              </ul>                                                                                                                                                                                                  </ul>
            </nav>

          </div>
          <div class="ml-auto">
            <div class="social-wrap">
              <a href="#"><span class="icon-facebook"></span></a>
              <a href="#"><span class="icon-twitter"></span></a>

              <a href="#" class="d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
                class="icon-menu h3"></span></a>
              </div>
            </div>

          </div>
        </div>

      </header>


  <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('images/bg_1.jpg')">
    <div class="container">
      <div class="row align-items-end">
        <div class="col-lg-7">
          <h2 class="mb-0"><fmt:message key="courseSingle.description"/></h2>
        </div>
      </div>
    </div>
  </div>


  <div class="custom-breadcrumns border-bottom">
    <div class="container">
      <a href="index.jsp"><fmt:message key="header.home"/></a>
      <span class="mx-3 icon-keyboard_arrow_right"></span>
      <a href="courses.jsp"><fmt:message key="header.faculty"/></a>
      <span class="mx-3 icon-keyboard_arrow_right"></span>
      <span class="current"><fmt:message key="header.faculty"/></span>
    </div>
  </div>

  <div class="site-section">
    <div class="container">
      <div class="row">
        <div class="col-md-6 mb-4">
          <p>
            <img src="images/course_1.jpg" alt="Image" class="img-fluid">
          </p>
        </div>
        <div class="col-lg-5 ml-auto align-self-center">
          <h2 class="section-title-underline mb-5">
            <span><fmt:message key="courseSingle.details"/></span>
          </h2>
          <p><fmt:message key="courseSingle_1.technologies"/></p>
          <p><fmt:message key="courseSingle_1.successfully"/></p>

          <p>
            <a href="#" class="btn btn-primary rounded-0 btn-lg px-5"><fmt:message key="courseSingle.enroll"/></a>
          </p>

        </div>
      </div>
    </div>
  </div>

  
      <div class="section-bg style-1" style="background-image: url('images/study.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-mortarboard"></span>
              <h3><fmt:message key="down.philosphy"/></h3>
              <p><fmt:message key="down.philosphyDescription"/></p>
            </div>
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-school-material"></span>
              <h3><fmt:message key="down.principle"/></h3>
              <p><fmt:message key="down.principleDescription"/></p>
            </div>
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-library"></span>
              <h3><fmt:message key="down.key"/></h3>
              <p><fmt:message key="down.keyDescription"/></p>
            </div>
          </div>
        </div>
      </div>


    <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-3">
            <p class="mb-4"><img src="images/logo_bsuir.png" alt="Image" class="img-fluid"></p>
          </div>
          <div class="col-lg-3">
            <h3 class="footer-heading"><span><fmt:message key="footer.university"/></span></h3>
            <ul class="list-unstyled">
              <li><a href="news-single.jsp"><fmt:message key="footer.news"/></a></li>
            </ul>
          </div>
          <div class="col-lg-3">
            <h3 class="footer-heading"><span><fmt:message key="footer.subjects"/></span></h3>
            <ul class="list-unstyled">
              <li><a href="course-single2.jsp"><fmt:message key="footer.science"/> &amp; <fmt:message key="footer.engineering"/></a></li>
              <li><a href="course-single6.jsp"><fmt:message key="footer.economics"/> &amp; <fmt:message key="footer.finance"/></a></li>
              <li><a href="course-single3.jsp"><fmt:message key="footer.science"/></a></li>
              <li><a href="course-single1.jsp"><fmt:message key="footer.contact"/></a></li>
            </ul>
          </div>
          <div class="col-lg-3">
            <h3 class="footer-heading"><span><fmt:message key="footer.center"/></span></h3>
            <ul class="list-unstyled">
              <li><a href="contact.jsp"><fmt:message key="footer.center"/></a></li>
            </ul>
          </div>
        </div>

        <div class="row">
          <div class="containerLan">
          <%@include file="../languageSelect.jsp" %>
          </div>
          <div class="col-12">
            <div class="copyright">
              <p>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                <fmt:message key="footer.copyright"/> &copy;<script>document.write(new Date().getFullYear());</script><fmt:message key="footer.rights"/></a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    

  </div>
  <!-- .site-wrap -->


  <!-- loader -->
  <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#51be78"/></svg></div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>




  <script src="js/main.js"></script>

</body>

</html>