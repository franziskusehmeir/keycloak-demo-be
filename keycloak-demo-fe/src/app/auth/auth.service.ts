import { Injectable } from '@angular/core';
import {OAuthService} from "angular-oauth2-oidc";
import {authCodeFlowConfig} from "./auth-config";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private oauthService: OAuthService) { }

  init(){
    this.oauthService.configure(authCodeFlowConfig);
  }
}
