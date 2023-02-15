module ptf.rs.parcijala2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens ptf.rs.parcijala2 to javafx.fxml;
    opens ptf.rs.parcijala2.models to javafx.base, org.hibernate.orm.core;
    opens ptf.rs.parcijala2.controllers to javafx.fxml;
    exports ptf.rs.parcijala2;
    exports ptf.rs.parcijala2.models;
    exports ptf.rs.parcijala2.repository;

    requires java.sql;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.persistence;
}