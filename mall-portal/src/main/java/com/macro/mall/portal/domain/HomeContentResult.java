package com.macro.mall.portal.domain;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.SmsHomeAdvertise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Homepage content return information package
 * Created by macro on 2019/1/28.
 */
@Getter
@Setter
public class HomeContentResult {
    //Carousel
    private List<SmsHomeAdvertise> advertiseList;
    //Recommended Brand
    private List<PmsBrand> brandList;
    //Current Flash sessions
    private HomeFlashPromotion homeFlashPromotion;
    //New Product
    private List<PmsProduct> newProductList;
    //Popular recommendation
    private List<PmsProduct> hotProductList;
    //Recommended topics
    private List<CmsSubject> subjectList;
}
