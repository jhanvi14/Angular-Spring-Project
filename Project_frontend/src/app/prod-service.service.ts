import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class ProdServiceService {

  constructor(private http: HttpClient) { }
  getProducts()
  {
    return this.http.get('http://localhost:8080/allProducts');
  }
  getProductsByCategory(cat)
  {
    
    return this.http.get('http://localhost:8080/allProducts/'+cat);
  }
  getProductById(id)
  {
    return this.http.get('http://localhost:8080/products/'+id);
  }
  getProductByCategAndPrice(cat,min,max)
  {
    return this.http.get('http://localhost:8080/allProducts/'+cat+'/'+min+'/'+max);
  }
  getByPrice(min,max)
  {
    return this.http.get('http://localhost:8080/allProducts/'+min+'/'+max);
  }
  addProduct(prod)
  {
    const headers = new HttpHeaders({Authorization:sessionStorage.getItem('basicAuth')});
    return this.http.post('http://localhost:8080/enterProducts',prod,{headers});
  }
  editProd(prod)
  {
    const headers = new HttpHeaders({Authorization:sessionStorage.getItem('basicAuth')});
    return this.http.post('http://localhost:8080/editProducts',prod,{headers}); 
  }
  getSearched(searched)
  {
    return this.http.get('http://localhost:8080/search/'+searched);
  }
}
