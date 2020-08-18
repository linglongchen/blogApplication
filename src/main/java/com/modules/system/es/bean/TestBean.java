package com.modules.system.es.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author v_vllchen
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "test",type = "_doc", shards = 1, replicas = 0)
public class TestBean {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secondCode;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;

    public TestBean(Long id,String firstCode,String secondCode,String content,Integer type){
        this.id=id;
        this.firstCode=firstCode;
        this.secondCode=secondCode;
        this.content=content;
        this.type=type;
    }
}
