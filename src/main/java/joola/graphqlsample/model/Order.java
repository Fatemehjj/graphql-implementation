package joola.graphqlsample.model;

public record Order(Flower flower,String owner, String ribbonColor,DeliveryMode deliveryMode) {
}
