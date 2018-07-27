import { Injectable } from "@angular/core";
import { HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";

/*
 * Adding Default HTTP Request Headers
 *
 * If you run the app at this point you will find that the browser pops up a Basic authentication dialogue (for user and password).
 * It does this because it sees a 401 reponse from the XHR requests to /user and /resource with a "WWW-Authenticate" header.
 * The way to suppress this popup is to suppress the header, which is coming from Spring Security.
 * And the way to suppress the reponse header is to send a special, conventional request header "X-Requested-With=XMLHttpRequest".
 */
@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}