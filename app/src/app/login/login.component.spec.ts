import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { RouterTestingModule } from '@angular/router/testing';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { MockService } from '../utils/mock-service.spec';

import { Router } from '@angular/router';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthService;
  let tokenStorageService: TokenStorageService;
  let router: Router;


  beforeEach(() => {
    authService = MockService.mock('AuthService', ['login', 'register']);
    tokenStorageService = MockService.mock('TokenStorageService', ['signOut', 'saveToken', 'getToken', 'saveUser', 'getUser']);
    router = MockService.mock('Router', ['navigate']);
  });



  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      providers: [
        { provide: AuthService, useValue: authService },
        { provide: TokenStorageService, useValue: tokenStorageService },
        { provide: Router, useValue: router }
      ],
      imports: [RouterTestingModule]
    });
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
