package joola.graphqlsample.model;

import java.util.List;

public record Store(List<Flower> orders, DeliveryMode deliveryMode) {
}
