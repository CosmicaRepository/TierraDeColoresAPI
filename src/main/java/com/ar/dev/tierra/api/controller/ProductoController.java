/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.dev.tierra.api.controller;

import com.ar.dev.tierra.api.model.JsonResponse;
import com.ar.dev.tierra.api.model.Producto;
import com.ar.dev.tierra.api.model.StockTierra;
import com.ar.dev.tierra.api.model.Usuarios;
import com.ar.dev.tierra.api.model.StockBebelandia;
import com.ar.dev.tierra.api.model.StockLibertador;
import com.ar.dev.tierra.api.model.WrapperStock;
import com.ar.dev.tierra.api.resource.FacadeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PauloGaldo
 */
@RestController
@RequestMapping("/producto")
public class ProductoController implements Serializable {

	@Autowired
	FacadeService facadeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		List<Producto> list = facadeService.getProductoDAO().getAll();
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/advanced", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> advanced(
			@RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion,
			@RequestParam(value = "marca", required = false, defaultValue = "") String marca,
			@RequestParam(value = "talla", required = false, defaultValue = "") String talla,
			@RequestParam(value = "codigo", required = false, defaultValue = "") String codigo,
			@RequestParam(value = "categoria", required = false, defaultValue = "") String categoria,
			@RequestParam(value = "page", required = false, defaultValue = "") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "") Integer size) {
		Page paged = facadeService.getProductoService().getByParams(descripcion, marca, talla, codigo, categoria, page,
				size);
		if (paged.getSize() != 0) {
			return new ResponseEntity<>(paged, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/full", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fullSearch(
			@RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion,
			@RequestParam(value = "marca", required = false, defaultValue = "") String marca,
			@RequestParam(value = "talla", required = false, defaultValue = "") String talla,
			@RequestParam(value = "codigo", required = false, defaultValue = "") String codigo,
			@RequestParam(value = "categoria", required = false, defaultValue = "") String categoria,
			@RequestParam(value = "temporada", required = false, defaultValue = "") String temporada,
			@RequestParam(value = "sexo", required = false, defaultValue = "") String sexo,
			@RequestParam(value = "clase", required = false, defaultValue = "") String clase,
			@RequestParam(value = "color", required = false, defaultValue = "") String color,
			@RequestParam(value = "proveedor", required = false, defaultValue = "") String proveedor,
			@RequestParam(value = "factura", required = false, defaultValue = "") String factura,
			@RequestParam(value = "page", required = false, defaultValue = "") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "") Integer size) {
		Page paged = facadeService.getProductoService().getByAllParams(descripcion, marca, talla, codigo, categoria,
				temporada, sexo, clase, color, proveedor, factura, page, size);
		if (paged.getSize() != 0) {
			return new ResponseEntity<>(paged, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/paged", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHotels(
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
			HttpServletRequest request, HttpServletResponse response) {
		Page paged = facadeService.getProductoService().getAllProdutos(page, size);
		if (paged.getSize() != 0) {
			return new ResponseEntity<>(paged, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(OAuth2Authentication authentication, @RequestBody Producto producto) {
		Usuarios user = facadeService.getUsuariosDAO().findUsuarioByUsername(authentication.getName());
		String descripcion = producto.getDescripcion();
		producto.setDescripcion(descripcion.toUpperCase());
		producto.setUsuarioCreacion(user.getIdUsuario());
		producto.setFechaCreacion(new Date());
		facadeService.getProductoDAO().add(producto);
		JsonResponse msg = new JsonResponse("Success", "Producto agregado con exito");
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> update(OAuth2Authentication authentication, @RequestBody Producto producto) {
		Usuarios user = facadeService.getUsuariosDAO().findUsuarioByUsername(authentication.getName());
		producto.setUsuarioModificacion(user.getIdUsuario());
		producto.setFechaModificacion(new Date());
		facadeService.getProductoDAO().update(producto);
		JsonResponse msg = new JsonResponse("Success", "Producto modificado con exito");
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN, ROLE_REPOSITOR')")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<?> delete(OAuth2Authentication authentication, @RequestBody Producto producto) {
		Usuarios user = facadeService.getUsuariosDAO().findUsuarioByUsername(authentication.getName());
		producto.setEstadoProducto(false);
		producto.setUsuarioModificacion(user.getIdUsuario());
		producto.setFechaModificacion(new Date());
		facadeService.getProductoDAO().delete(producto);
		JsonResponse msg = new JsonResponse("Success", "Producto eliminado con exito");
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<?> findById(@RequestParam("id") int id) {
		Producto p = facadeService.getProductoDAO().findById(id);
		if (p == null || p.isEstadoProducto() == false) {
			JsonResponse jr = new JsonResponse("error", "No se encontro el producto");
			return new ResponseEntity<>(jr, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/searchText", method = RequestMethod.POST)
	public ResponseEntity<?> findByText(@RequestParam("text") String text) {
		List<Producto> productos = facadeService.getProductoDAO().findByText(text.toUpperCase());
		if (!productos.isEmpty()) {
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(productos, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/barcode", method = RequestMethod.POST)
	public ResponseEntity<?> findByBarcode(@RequestParam("barcode") String barcode) {
		List<Producto> list = facadeService.getProductoDAO().findByBarcode(barcode);
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public ResponseEntity<?> findByBarcodeInStock(@RequestParam("barcode") String barcode,
			OAuth2Authentication authentication) {
		Usuarios user = facadeService.getUsuariosDAO().findUsuarioByUsername(authentication.getName());
		List<WrapperStock> list = facadeService.getStockDAO()
				.searchByBarcodeInStock(user.getUsuarioSucursal().getIdSucursal(), barcode);
		List<StockTierra> tierra = new ArrayList<>();
		List<StockBebelandia> bebelandia = new ArrayList<>();
		List<StockLibertador> libertador = new ArrayList<>();
		switch (user.getUsuarioSucursal().getIdSucursal()) {
		case 1:
			for (WrapperStock wrapperStock : list) {
				tierra.add(wrapperStock.getStockTierra());
			}
			break;
		case 2:
			for (WrapperStock wrapperStock : list) {
				bebelandia.add(wrapperStock.getStockBebelandia());
			}
			break;
		case 3:
			for (WrapperStock wrapperStock : list) {
				libertador.add(wrapperStock.getStockLibertador());
			}
			break;
		}
		if (tierra.isEmpty() && bebelandia.isEmpty()) {
			return new ResponseEntity<>(libertador, HttpStatus.OK);
		} else if (bebelandia.isEmpty() && libertador.isEmpty()) {
			return new ResponseEntity<>(tierra, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bebelandia, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/list/factura", method = RequestMethod.POST)
	public ResponseEntity<?> findByIdFactura(@RequestParam("idFacturaProducto") int idFacturaProducto) {
		List<Producto> list = facadeService.getProductoDAO().findByIdFactura(idFacturaProducto);
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/list/factura/paged", method = RequestMethod.GET)
	public ResponseEntity<?> findByIdFacturaPaged(@RequestParam("idFacturaProducto") int idFacturaProducto,
			@RequestParam(value = "page", required = false, defaultValue = "") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "") Integer size) {
		Page<Producto> paged = facadeService.getProductoService().findByFactura(page, size, idFacturaProducto);
		if (paged.getSize() != 0) {
			return new ResponseEntity<>(paged, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
