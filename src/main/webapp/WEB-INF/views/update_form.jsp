<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp" %>
<title>Add Product</title>
</head>
<body>
	<%-- <div class="row">
	<div class="col-md6 offset-md-3">
	<h1 class="text-center mb-3">Fill product details</h1>
	<form action="handle-product" method="post">
	<div class="form-group">
	<label for="name">Product Name</label>
	<input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name" placeholder="Enter the product name here">
	</div>
	
	<div class="form-group">
	<label for="description">Product Description</label>
	<textarea class="form-control" id="description" name="description" row="5" placeholder="Enter the product description here"></textarea>
	</div>
	
	<div class="form-group">
	<label for="price">Product Price</label>
	<input type="text" class="form-control" id="price" name="price" placeholder="Enter the product price here">
	</div>
	
	<div class="container text-center">
	<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
	<button type="submit" class="btn btn-primary">Add</button>
	</div>
	
	</form>
	</div>
	</div> --%>
	
	<div class="row justify-content-center">
    <div class="col-md-6">
        <h1 class="text-center mb-3">Update Product Details</h1>
        <form action="${pageContext.request.contextPath }/handle-product" method="post">
        <input type="hidden" value="${product.id }" name="id">
            <div class="form-group">
                <label for="name">Product Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter the product name here" value="${product.name}">
            </div>
            
            <div class="form-group">
                <label for="description">Product Description</label>
                <textarea class="form-control" id="description" name="description" rows="5" placeholder="Enter the product description here">${product.description }</textarea>
            </div>
            
            <div class="form-group">
                <label for="price">Product Price</label>
                <input type="text" class="form-control" id="price" name="price" placeholder="Enter the product price here" value="${product.price }">
            </div>
            
            <div class="text-center mt-3">
                <a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
                <button type="submit" class="btn btn-warning">Update</button>
            </div>
        </form>
    </div>
</div>
	
</body>
</html>