package com.caseStudy.ShopAll.Controller;

import com.caseStudy.ShopAll.Repository.userRepository;
import com.caseStudy.ShopAll.Service.CartService;
import com.caseStudy.ShopAll.model.Cart;
import com.caseStudy.ShopAll.model.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class cartController {

    @Autowired
    CartService cartS;
    @Autowired
    userRepository userR;

    @GetMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable("productId") String productId,Principal principal) {
        return cartS.addProduct(userR.findByEmail(principal.getName()).getUserId(), productId);

    }

    @GetMapping("/showCart")
    public List<Cart> showCart(Authentication auth)
    {
        System.out.println(userR.findByEmail(auth.getName()).getUserId());
        String id = userR.findByEmail(auth.getName()).getUserId();
        return  cartS.showCart(id);
    }

    @GetMapping("/clearCart")
    public String clearCart(Principal principal)
    {
        String id = userR.findByEmail(principal.getName()).getUserId();
        return cartS.clearCart(id);
    }
    @GetMapping("/decreaseQuantity/{productId}")
    public String decQ(@PathVariable("productId") String productId,Principal principal)
    {
        return cartS.decreaseQuant(productId,principal);

    }
    @Transactional
    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(Principal principal,@PathVariable("productId") String productId)
    {
        return cartS.deleteProduct(principal,productId);
    }

    @GetMapping("/checkOut")
    public List<OrderHistory> checkout(Principal principal)
    {
        System.out.println(cartS.checkOut(principal).toString());
        return cartS.checkOut(principal);
    }

}
