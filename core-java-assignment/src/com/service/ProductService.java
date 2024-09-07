package com.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.Product;

public class ProductService {

	private static List<Product> listOfProducts = new ArrayList<Product>();
	
	public String addProduct(Product product) {
		int flag = 0;
		if(listOfProducts.size()==0) {
		listOfProducts.add(product);
		return "Product added successfully";
		}else {
				Iterator<Product>	li = listOfProducts.iterator();
				while(li.hasNext()) {
					Product p  = li.next();
					if(p.getPid()==product.getPid()) {
						flag++;
						break;
					}
				}
		}
		if(flag==0) {
			listOfProducts.add(product);
			return "Product added successfully";
		}else {
			flag =0;
			return "Product is must be unique";
		}
	}

	public List<Product> findAllProducts(){
		return listOfProducts;
	}
	
	public String deleteProduct(int pid) {
		int flag = 0;
				
		Iterator<Product>	li = listOfProducts.iterator();
		while(li.hasNext()) {
		Product p  = li.next();
		if(p.getPid()==pid) {
			li.remove();
				flag++;
				break;
				}
		}
		
		if(flag==0) {
			return "Product not present";
		}else {
			flag =0;
			return "Product deleted successfully";
		}
	}
	public String updatetProduct(Product product) {
		int flag = 0;		
		Iterator<Product>	li = listOfProducts.iterator();
		while(li.hasNext()) {
		Product p  = li.next();
		if(p.getPid()==product.getPid()) {
			p.setPrice(product.getPrice());
				flag++;
				break;
				}
		}
		if(flag==0) {
			return "Product not present";
		}else {
			flag =0;
			return "Product price updated successfully";
		}
	}
	
	public void serializeObject() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Documents\\Assignment_workspace\\employee.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(listOfProducts);
		oos.close();
		System.out.println("object serialization done!");
	}
	
	public void deSerializeObject() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Documents\\Assignment_workspace\\employee.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		listOfProducts = (List<Product>)obj;
	}
}