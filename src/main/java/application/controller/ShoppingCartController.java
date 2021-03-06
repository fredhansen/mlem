package application.controller;

import application.entities.Product;
import application.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

/*    @Autowired
    private OrderRepository orderRepository;*/

    @RequestMapping("/cart")
    public String cart(Model model) {

        model.addAttribute("products", productRepository.getAllProducts());
        model.addAttribute("cartProducts", productRepository.getAllProducts());

        return "shoppingCart";
    }


    @GetMapping(value = "/cart/add/{id}/{qt}")
    public String add(@PathVariable("id") String id, @PathVariable Integer qt, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            Map<Product, Integer> cart = new HashMap<>();

            cart.put(productRepository.getById(id), qt);
            session.setAttribute("cart", cart);

        } else {
            Map<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

            if (!cart.containsKey(productRepository.getById(id))) {
                cart.put(productRepository.getById(id), qt);
            } else {
                cart.replace(productRepository.getById(id), qt);
            }


            session.setAttribute("cart", cart);
        }
        return "redirect:/products/detail/" + id;
    }


    @GetMapping(value = "/cart/remove/{id}")
    public String remove(@PathVariable("id") String id, HttpSession session) {
        Map<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

        cart.remove(productRepository.getById(id));

        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping(value = "/cart/checkout/")
    public String checkout(HttpSession session, Model model) {
        Map<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {

            double price = entry.getKey().getPrice();
            int amount = entry.getValue();

            total = total + price * amount;
        }

        session.setAttribute("totalPrice", total);
        model.addAttribute("total", total);
        return "checkout";
    }

    @PostMapping("cart/checkout/confirm")
    public String confirmCart(HttpSession session, Model model) {
        Map<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");
        // todo cart sent to database and to admin for order

        double toBePayed = (Double) session.getAttribute("total");
        // todo amount to be sent to bank

        // todo create sale/order entity
        return "";
    }
//
//    @GetMapping(value = "/cart/checkout/")
//    public String confirmed(HttpSession session, Model model) {
//        Map<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");
//        // todo cart sent to database and to admin for order
//
//        double toBePayed = (Double) session.getAttribute("total");
//        // todo amount to be sent to bank
//
//        // todo create sale/order entity
//        return "";
//    }

}
