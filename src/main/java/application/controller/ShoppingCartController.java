package application.controller;

import application.entities.Product;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/cart")
    public String cart(Model model) {

        model.addAttribute("products", productRepository.getAllProducts());
        model.addAttribute("cartProducts", productRepository.getAllProducts());

        return "shoppingCart";
    }



    @GetMapping(value = "/cart/add/{id}")
    public String add(@PathVariable("id") String id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Product> cart = new ArrayList<>();
            cart.add(productRepository.getById(id));
            session.setAttribute("cart", cart);
        } else {
            List<Product> cart = (List<Product>) session.getAttribute("cart");

            for (int i = 0; i < cart.size(); i++) {
                if(cart.get(i).getId() == Long.parseLong(id)) {
                    return "redirect:/products/detail/" + id;
                }
            }

            cart.add(productRepository.getById(id));
            session.setAttribute("cart", cart);
        }
        return "redirect:/products/detail/" + id;
    }


    @GetMapping(value = "/cart/remove/{id}")
    public String remove(@PathVariable("id") String id, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == Long.parseLong(id)) {
                cart.remove(i);
            }
        }

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

}
