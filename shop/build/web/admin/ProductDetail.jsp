<%@page import="Classes.Products"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="DAO.Product_DAO"%>
<%@page import="Classes.Brands"%>
<%@page import="DAO.Category_DAO"%>
<%@page import="Classes.Category"%>
<%@page import="DAO.Order_DAO"%>
<%@page import="Classes.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
    <script src="ckeditor/ckeditor.js"></script>
<%
    if (request.getParameter("BrandID") == null) {
%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý sản phẩm</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý  sản phẩm</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">


                    <%
                        if (request.getParameter("ProID") == null) {
                    %>  
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Tạo mới  sản phẩm</b></div>
                    <div class="panel-body" >
                        <form action="/shop/ManageProduct" method="post">
                            <input type="hidden"  name="Command"  value="Add"/>
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Tên sản phẩm:</label>
                                <input type="text" class="form-control" name="Name" value="" required>
                            </div>

                            <%
                                ArrayList<Category> lstCAT = Category_DAO.getListCategory();
                            %>
                            <div class="form-group">
                                <label for="pwd">Danh mục :</label>
                                <select class="form-control" name="CatID">
                                    <%for (Category cat : lstCAT) {%>
                                    <option value="<%=cat.getID()%>"><%=cat.getName()%></option>
                                    <%}%>
                                </select>
                            </div>

                            <%
                                ArrayList<Brands> lstBrand = Brand_DAO.getListBrands();
                            %>
                            <div class="form-group">
                                <label for="pwd">Nhà sản xuất :</label>
                                <select class="form-control" name="BrandID">
                                    <% for (Brands br : lstBrand) {%>
                                    <option value="<%=br.getID()%>"><%=br.getName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Mô tả : </label>
                                <textarea name="Des" id="ten" rows="2000">
                                <h1>Hello</h1>
                                </textarea>
                                <script>CKEDITOR.replace('ten');</script>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Mô tả ngắn:</label>
                                <input type="text" class="form-control" name="ShortDes" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Giá:</label>
                                <input type="text" class="form-control" name="Price" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Ngày ra mắt:</label>
                                <input type="text" class="form-control" name="Date" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Độ phân giải màn hình:</label>
                                <input type="text" class="form-control" name="Resolution" value="">
                            </div><div class="form-group">
                                <label for="pwd">CPU:</label>
                                <input type="text" class="form-control" name="CPU" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">RAM:</label>
                                <input type="text" class="form-control" name="RAM" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Bộ nhớ trong:</label>
                                <input type="text" class="form-control" name="Storage" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">GPU:</label>
                                <input type="text" class="form-control" name="GPU" value="">
                            </div>
                            <input type="submit" id="submit"  value="Thêm mới" style="margin-left: 0" class="btn btn-danger form-control"/>  
                        </form>
                        <%} else {
                            int ID = Integer.parseInt(request.getParameter("ProID"));
                            Products pro = Product_DAO.GetProductByID(ID);
                        %>
                        <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Sửa sản phẩm</b></div>
                        <div class="panel-body" >
                            <form action="/shop/ManageProduct" method="post">
                                <input name="Command" type="hidden" value="Edit"/>
                                <input type="hidden" name="ProID" value="<%=pro.getID()%>"/>
                                <div class="form-group">
                                    <input type="hidden" value="" name="ID"/>
                                    <label for="usr">Tên sản phẩm:</label>
                                    <input type="text" class="form-control" name="Name" value="<%=pro.getFullName()%>" required>
                                </div>

                                <%
                                    ArrayList<Category> lstCAT = Category_DAO.getListCategory();
                                %>
                                <div class="form-group">
                                    <label for="pwd">Danh mục :</label>
                                    <select class="form-control" name="CatID">
                                        <%for (Category cat : lstCAT) {%>
                                        <option value="<%=cat.getID()%>"><%=cat.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>

                                <%
                                    ArrayList<Brands> lstBrand = Brand_DAO.getListBrands();
                                %>
                                <div class="form-group">
                                    <label for="pwd">Nhà sản xuất :</label>
                                    <select class="form-control" name="BrandID">
                                        <% for (Brands br : lstBrand) {%>
                                        <option value="<%=br.getID()%>"><%=br.getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Mô tả : </label>
                                    <textarea name="Des" id="ten" rows="2000">
                                        <%=pro.getDES().replace("<", "&lt;").replace(">", "&gt;")%>
                                    </textarea>
                                    <script>
                                        CKEDITOR.replace('ten');
                                    </script>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Mô tả ngắn:</label>
                                    <input type="text" class="form-control" name="ShortDes" value="<%=pro.getShortDes()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Giá:</label>
                                    <input type="number" class="form-control" name="Price" value="<%=pro.getPrice()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Ngày ra mắt:</label>
                                    <input type="datetime" class="form-control" name="Date" value="<%=pro.getReleasedate()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Độ phân giải màn hình:</label>
                                    <input type="text" class="form-control" name="Resolution" value="<%=pro.getScreenresolution()%>">
                                </div><div class="form-group">
                                    <label for="pwd">CPU:</label>
                                    <input type="text" class="form-control" name="CPU" value="<%=pro.getCpu()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">RAM:</label>
                                    <input type="text" class="form-control" name="RAM" value="<%=pro.getRam()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Bộ nhớ trong:</label>
                                    <input type="text" class="form-control" name="Storage" value="<%=pro.getInternalmemory()%>">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">GPU:</label>
                                    <input type="text" class="form-control" name="GPU" value="<%=pro.getGPU()%>">
                                </div>
                                <input type="submit" id="submit"  value="Thêm mới" style="margin-left: 0" class="btn btn-danger form-control"/>  
                            </form>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
    </section>
</div>
<%}%>
<jsp:include page="footer.jsp"></jsp:include>