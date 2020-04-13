package com.nosbielc.resource;

import com.nosbielc.domain.model.Product;
import com.nosbielc.dto.ProductDTO;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 07/04/2020
 * @project Quarkus-Examples
 */
@Path(value = "products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> listAllProducts() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public Product create(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setVlr(product.getVlr());

        product.persist();

        return product;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Product.findById(id).delete();
    }
}
