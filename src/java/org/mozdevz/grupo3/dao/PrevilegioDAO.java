/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.dao;

import org.mozdevz.grupo3.model.Previlegio;


/**
 *
 * @author Francisco Joshua
 */
public class PrevilegioDAO extends DAOAbstracto<Previlegio> {

    public PrevilegioDAO() {
        super(Previlegio.class);
        ordenarResultados("previlegio", DAOAbstracto.ORDEM_ASCENDENTE);
    }

    @Override
    public Previlegio buscarPorChavePrimaria(Object id) {
        return listarPorChavePrimaria("id", id);
    }
}
