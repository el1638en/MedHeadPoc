import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileComponent } from './profile.component';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { MockService } from '../utils/mock-service.spec';

describe('ProfileComponent', () => {
  let component: ProfileComponent;
  let fixture: ComponentFixture<ProfileComponent>;
  let userService: UserService;
  let tokenStorageService: TokenStorageService;


  beforeEach(() => {
    userService = MockService.mock('UserService', ['getPublicContent', 'getUserContent',
      'getUserByEmail', 'getNearestHospital', 'registerPatientInfo', 'getAllSpecialityGroups', 'getSpecialitiesBySpecialityGroupByName',
      'getSpecialitiesBySpecialityGroupById', 'getPerimeter']);
    tokenStorageService = MockService.mock('TokenStorageService', ['signOut', 'saveToken', 'getToken', 'saveUser', 'getUser']);
  });



  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfileComponent],
      providers: [
        { provide: UserService, useValue: userService },
        { provide: TokenStorageService, useValue: tokenStorageService }
      ],
    });
    fixture = TestBed.createComponent(ProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
