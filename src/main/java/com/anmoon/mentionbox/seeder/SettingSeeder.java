package com.anmoon.mentionbox.seeder;

import com.anmoon.mentionbox.entity.SettingEntity;
import com.anmoon.mentionbox.enumeration.SettingEnum;
import com.anmoon.mentionbox.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SettingSeeder {
    private final SettingRepository settingRepository;

    @Autowired
    public SettingSeeder(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    private void seedSettings() {
        SettingEntity  maintenanceMode = new SettingEntity();
        maintenanceMode.setKey(SettingEnum.maintenanceMode.name());
        maintenanceMode.setValue(String.valueOf(true));
        settingRepository.save(maintenanceMode);

        SettingEntity enableSearchCapatcha = new SettingEntity();
        enableSearchCapatcha.setKey("enableSearchCapatcha");
        enableSearchCapatcha.setValue(String.valueOf(true));
        settingRepository.save(enableSearchCapatcha);

        SettingEntity enableContactCapatcha = new SettingEntity();
        enableContactCapatcha.setKey("enableContactCapatcha");
        enableContactCapatcha.setValue(String.valueOf(true));
        settingRepository.save(enableContactCapatcha);

        SettingEntity enableRegister = new SettingEntity();
        enableRegister.setKey("enableRegister");
        enableRegister.setValue(String.valueOf(true));
        settingRepository.save(enableRegister);

        SettingEntity enableBanner = new SettingEntity();
        enableBanner.setKey("enableBanner");
        enableBanner.setValue(String.valueOf(true));
        settingRepository.save(enableBanner);

        SettingEntity bannerContent = new SettingEntity();
        bannerContent.setKey("bannerContent");
        bannerContent.setValue(String.valueOf(true));
        settingRepository.save(bannerContent);

        SettingEntity guestItemViewNumber = new SettingEntity();
        guestItemViewNumber.setKey("guestItemViewNumber");
        guestItemViewNumber.setValue("8");
        settingRepository.save(guestItemViewNumber);

        SettingEntity enableAdvancedSearch = new SettingEntity();
        enableAdvancedSearch.setKey("enableAdvancedSearch");
        enableAdvancedSearch.setValue(String.valueOf(true));
        settingRepository.save(enableAdvancedSearch);

        SettingEntity enableContext = new SettingEntity();
        enableContext.setKey("enableContext");
        enableContext.setValue(String.valueOf(true));
        settingRepository.save(enableContext);

        SettingEntity enableDetails = new SettingEntity();
        enableDetails.setKey("enableDetails");
        enableDetails.setValue(String.valueOf(true));
        settingRepository.save(enableDetails);

        SettingEntity enableView = new SettingEntity();
        enableView.setKey("enableView");
        enableView.setValue(String.valueOf(true));
        settingRepository.save(enableView);

        SettingEntity enableDownload = new SettingEntity();
        enableDownload.setKey("enableDownload");
        enableDownload.setValue(String.valueOf(true));
        settingRepository.save(enableDownload);

        SettingEntity enableScrollLoading = new SettingEntity();
        enableScrollLoading.setKey("enableScrollLoading");
        enableScrollLoading.setValue(String.valueOf(true));
        settingRepository.save(enableScrollLoading);

        SettingEntity enableRequests = new SettingEntity();
        enableRequests.setKey("enableRequests");
        enableRequests.setValue(String.valueOf(true));
        settingRepository.save(enableRequests);

        SettingEntity enableActivityLogs = new SettingEntity();
        enableActivityLogs.setKey("enableActivityLogs");
        enableActivityLogs.setValue(String.valueOf(true));
        settingRepository.save(enableActivityLogs);
    }
}

