·       User should be able to review order and confirm it.·       User should be able to receive order confirmation message.

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/{orderId}/confirm")
    public ResponseEntity<Order> confirmOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.confirmOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}