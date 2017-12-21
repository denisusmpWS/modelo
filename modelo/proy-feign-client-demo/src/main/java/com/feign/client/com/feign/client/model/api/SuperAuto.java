package com.feign.client.com.feign.client.model.api;

import com.feign.client.com.feign.client.model.proxy.Auto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAuto {

    private int superId;
    private String category;
    private List<Auto> autos;
    private String serial;
    private String organization;
    private String awt;

}
