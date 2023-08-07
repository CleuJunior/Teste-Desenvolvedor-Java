package com.automobilefleet.utils.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.automobilefleet.api.dto.request.SpecificationRequest;
import com.automobilefleet.api.dto.response.BrandResponse;
import com.automobilefleet.api.dto.response.CarResponse;
import com.automobilefleet.api.dto.response.CategoryResponse;
import com.automobilefleet.api.dto.response.SpecificationResponse;
import com.automobilefleet.entities.Brand;
import com.automobilefleet.entities.Car;
import com.automobilefleet.entities.Category;
import com.automobilefleet.entities.Specification;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarTemplateLoader implements TemplateLoader {

    // Car
    private static final UUID ID = UUID.fromString("4f2e3bc7-8522-4543-922c-03480d044e62");
    private static final String NAME = "488";
    private static final String DESCRIPTION = "Esportivo da Ferrari";
    private static final Double DAILY_RATE = 1_500.0;
    private static final Boolean AVAILABLE = false;
    private static final String LICENSE_PLATE = "LMN-3456";
    private static final String COLOR = "Vermelho";
    private static final LocalDateTime CREATED_AT = LocalDateTime.of(2017, 3, 12, 22, 28, 12);

    // Brand
    private static final UUID ID_BRAND = UUID.fromString("4f2dd5bb-ae60-41ca-9227-0fb3dacebcbe");
    private static final String BRAND_NAME =  "Ferrari";

    // Category
    private static final UUID ID_CATEGORY = UUID.fromString("146c8a0a-828c-4d4c-bbc3-fdc70bcf38f9");
    private static final String NAME_CATEGORY = "Coupé";
    private static final String DESCRIPTION_CATEGORY = "Categoria de carros com carroceria coupé";

    @Override
    public void load() {
        Fixture.of(Car.class).addTemplate("car", new Rule() {{
            add("id", ID);
            add("name", NAME);
            add("description", DESCRIPTION);
            add("dailyRate", DAILY_RATE);
            add("isAvailable", AVAILABLE);
            add("licensePlate", LICENSE_PLATE);
            add("brand", buildBrand());
            add("category", buildCategory());
            add("color", COLOR);
            add("createdAt", CREATED_AT);
        }});

        Fixture.of(CarResponse.class).addTemplate("response", new Rule() {{
            add("id", ID);
            add("name", NAME);
            add("description", DESCRIPTION);
            add("dailyRate", DAILY_RATE);
            add("isAvailable", AVAILABLE);
            add("licensePlate", LICENSE_PLATE);
            add("brand", new BrandResponse());
            add("category", new CategoryResponse());
            add("color", COLOR);
            add("createdAt", CREATED_AT);
        }});
    }

    private Brand buildBrand() {
        return Brand
                .builder()
                .id(UUID.fromString("4f2dd5bb-ae60-41ca-9227-0fb3dacebcbe"))
                .name("Ferrari")
                .createdAt(CREATED_AT)
                .build();
    }

    private Category buildCategory() {
        return Category
                .builder()
                .id(UUID.fromString("146c8a0a-828c-4d4c-bbc3-fdc70bcf38f9"))
                .name("Coupé")
                .description("Categoria de carros com carroceria coupé")
                .createdAt(CREATED_AT)
                .build();
    }

    private BrandResponse buildBrandReponse() {
        return new BrandResponse(ID_BRAND, BRAND_NAME, CREATED_AT);
    }

    private CategoryResponse buildCategoryResponse() {
        return new CategoryResponse(ID_CATEGORY, NAME_CATEGORY, DESCRIPTION_CATEGORY, CREATED_AT);
    }
}