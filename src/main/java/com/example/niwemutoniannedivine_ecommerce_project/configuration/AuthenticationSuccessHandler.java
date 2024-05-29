package com.example.niwemutoniannedivine_ecommerce_project.configuration;//package com.web.ecommerceweb.configuration;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import java.io.IOException;
//
//public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//       boolean isAdmin = authentication.getAuthorities()
//               .stream().anyMatch(g -> g.getAuthority().equals("ROLE_ADMIN"));
//       if (isAdmin){
//           setDefaultTargetUrl("/admin/*");
//        }else {
//           setDefaultTargetUrl("/cart");
//       }
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//    // Method to check if the requested URL matches any user URLs
//    private boolean isUserUrl(String requestUrl) {
//        String[] userUrls = {"/shop/**", "/addToCart/", "/cart", "/checkout/", "/payNow", "/confirmation", "/users/"};
//        for (String urlPattern : userUrls) {
//            if (requestUrl.startsWith(urlPattern)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
