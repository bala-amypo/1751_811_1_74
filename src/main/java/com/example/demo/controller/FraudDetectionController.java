
@RestController
@RequestMapping("/api/fraud-check")
public class FraudDetectionController {

    private final FraudDetectionService service;

    public FraudDetectionController(FraudDetectionService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{claimId}")
    public FraudCheckResult evaluate(@PathVariable Long claimId) {
        return service.evaluate(claimId);
    }
}
