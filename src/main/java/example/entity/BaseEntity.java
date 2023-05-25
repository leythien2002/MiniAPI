package example.entity;

import jakarta.persistence.*;

import java.util.Date;
//nhung properties trong base voi id collumn no se apply cho nhung tk thua ke
//neu ko su dung mapped nay thi nhung class ke thua se ko generate duoc cai field trong table
@MappedSuperclass
public abstract class BaseEntity {
    //primary key and notnull
    @Id
    //ho tro tao id tu dong.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    //generate field vao table trong sql
    private String createdBy;
    @Column
    private Date createdDate;
    @Column
    private String modifiedBy;
    @Column
    private Date modifiedDate;
}
