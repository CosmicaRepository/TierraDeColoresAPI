/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.dev.tierra.api.dao;

import com.ar.dev.tierra.api.model.Chart;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PauloGaldo
 */
@Component
@Repository
public interface ChartDAO {

    public List<Chart> getVentaVendedores(int idVendedor);

    public List<Chart> getDineroVendedores(int idVendedor);

    public List<Chart> getMontoMedioPago(int idMedioPago);
    
    public List<Chart> getVentaMedioPago(int idMedioPago);

}
