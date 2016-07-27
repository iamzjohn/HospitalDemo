/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mozdevz.grupo3.util;

import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;
import org.hibernate.type.IntegerType;

/**
 * Classe destinada a adicionar funcoes de busca de datas que nao existem na
 * implementacao padrao do Hibernate.
 * <br> Esta classe baseou-se na implementacao da classe
 * {@link org.hibernate.criterion.Restrictions} implementada no Hibernate v3.x.x
 *
 * @author Francisco Joshua
 */
public class DateExpression {

    public static Criterion dayEq(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, "=");
    }

    public static Criterion dayGT(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, ">");
    }

    public static Criterion dayGEq(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, ">=");
    }

    public static Criterion dayLT(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, "<");
    }

    public static Criterion dayLEq(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, "<=");
    }

    public static Criterion dayNot(String propertyName, Integer day) {
        return new DayExpression(propertyName, day, "<>");
    }

    public static Criterion monthEq(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, "=");
    }

    public static Criterion monthGT(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, ">");
    }

    public static Criterion monthGEq(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, ">=");
    }

    public static Criterion monthLT(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, "<");
    }

    public static Criterion monthLEq(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, "<=");
    }

    public static Criterion monthNot(String propertyName, Integer month) {
        return new MonthExpression(propertyName, month, "<>");
    }

    public static Criterion yearEq(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, "=");
    }

    public static Criterion yearGT(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, ">");
    }

    public static Criterion yearGEq(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, ">=");
    }

    public static Criterion yearLT(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, "<");
    }

    public static Criterion yearLEq(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, "<=");
    }

    public static Criterion yearNot(String propertyName, Integer year) {
        return new YearExpression(propertyName, year, "<>");
    }

    public static class DayExpression implements Criterion {

        private final String propertyName;
        private final String operation;
        private final int day;

        public DayExpression(String propertyName, int day, String operation) {
            this.propertyName = propertyName;
            this.day = day;
            this.operation = operation;
        }

        @Override
        public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
                throws HibernateException {
            String[] columns = criteriaQuery.findColumns(propertyName, criteria);
            if (columns.length != 1) {
                throw new HibernateException("dayExpression may only be used with single-column properties");
            }
            return "day(" + columns[0] + ") " + operation + " ?";
        }

        @Override
        public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
            return new TypedValue[]{new TypedValue(IntegerType.INSTANCE, day, EntityMode.POJO)};
        }

        @Override
        public String toString() {
            return "day(" + propertyName + ") " + operation + " " + day;
        }
    }

    public static class MonthExpression implements Criterion {

        private final String propertyName;
        private final String operation;
        private final int month;

        public MonthExpression(String propertyName, int month, String operation) {
            this.propertyName = propertyName;
            this.month = month;
            this.operation = operation;
        }

        @Override
        public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
                throws HibernateException {
            String[] columns = criteriaQuery.findColumns(propertyName, criteria);
            if (columns.length != 1) {
                throw new HibernateException("monthExpression may only be used with single-column properties");
            }
            return "month(" + columns[0] + ") " + operation + " ?";
        }

        @Override
        public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
            return new TypedValue[]{new TypedValue(IntegerType.INSTANCE, month, EntityMode.POJO)};
        }

        @Override
        public String toString() {
            return "month(" + propertyName + ") " + operation + " " + month;
        }
    }

    public static class YearExpression implements Criterion {

        private final String propertyName;
        private final String operation;
        private final int year;

        public YearExpression(String propertyName, int year, String operation) {
            this.propertyName = propertyName;
            this.year = year;
            this.operation = operation;
        }

        @Override
        public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
                throws HibernateException {
            String[] columns = criteriaQuery.findColumns(propertyName, criteria);
            if (columns.length != 1) {
                throw new HibernateException("yearExpression may only be used with single-column properties");
            }
            return "year(" + columns[0] + ") " + operation + " ?";
        }

        @Override
        public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
            return new TypedValue[]{new TypedValue(IntegerType.INSTANCE, year, EntityMode.POJO)};
        }

        @Override
        public String toString() {
            return "year(" + propertyName + ") " + operation + " " + year;
        }
    }
}
