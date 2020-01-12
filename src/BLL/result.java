/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Arber
 */
@Entity
    public class result{
        @Id int nr;
        int dhomaid;

        public result(int nr, int dhomaid) {
            this.nr = nr;
            this.dhomaid = dhomaid;
        }
        
        public int getDhomaID() {
            return dhomaid;
        }

        public void setDhomaID(int DhomaID) {
            this.dhomaid = DhomaID;
        }
        
        public int getNr() {
            return nr;
        }

        public void setNr(int nr) {
            this.nr = nr;
        }
         /**
         * Generic put method to map JPA native Query to this object.
         *
         * @param column
         * @param value
         */
        public void put(Object column, Object value) {
            if (((String) column).equals("nr")) {
                this.setNr(Integer.parseInt(((String) value)));
            } else if (((String) column).equals("dhomaid")) {
                this.setDhomaID(Integer.parseInt(((String) value)));
            }
        }
    }
