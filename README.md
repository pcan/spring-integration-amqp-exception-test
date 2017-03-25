# spring-integration-amqp-exception-test

Test project for remote exception handling using Spring Integration AMQP. This implementation uses direct reply-to mechanism in order to decouple client and server.

## Key points

- `error-channel`: this channel catches errors and forward them to the `ErrorHandler`.
- `ErrorHandler`: this service inspects the `Message` and wraps exception in a `RuntimeExceptionHolder` object (this is necessary due to the way `MessagingGatewaySupport.doSendAndReceive` works: if the response body is a `Throwable`, it is rethrown) and returns it as response with the original response headers (here we copy the original direct reply-to headers in the error message).
- `ClientErrorInterceptor`: this interceptor checks the response body type: if it's a `RuntimeExceptionHolder`, the original exception is unwrapped and thrown to the caller.
