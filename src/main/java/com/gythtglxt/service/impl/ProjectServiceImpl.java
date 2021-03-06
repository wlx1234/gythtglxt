package com.gythtglxt.service.impl;
import java.util.*;

import com.gythtglxt.dataobject.FileDO;
import com.gythtglxt.dto.ProjectDto;
import com.gythtglxt.error.BusinessException;
import com.gythtglxt.error.EmBusinessError;
import com.gythtglxt.service.IFileService;
import com.gythtglxt.util.DateUtils;
import com.gythtglxt.util.UsernameUtil;
import com.gythtglxt.validator.ValidatorImpl;
import com.gythtglxt.validator.ValidatorResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gythtglxt.dataobject.Project;
import com.gythtglxt.dao.ProjectMapper;
import com.gythtglxt.service.IProjectService;
@Service
@SuppressWarnings("all")
public class ProjectServiceImpl implements IProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private IFileService fileService;

    @Resource
    private UsernameUtil usernameUtil;

    @Resource
    private ValidatorImpl validator;

    @Override
    public int deleteByPrimaryKey(Integer itemid, String itemcode) {
        return projectMapper.deleteByPrimaryKey(itemid, itemcode);
    }

    @Override
    public int insertSelective(Project record) {
        ValidatorResult validate = validator.validate(record);
        if (validate.isHasErrors()) {
            throw new BusinessException(validate.getErrMsg(), EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        record.setCreater(usernameUtil.getOperateUser());
        record.setItemcreateat(DateUtils.getDate());
        record.setUpdater(usernameUtil.getOperateUser());

        return projectMapper.insertSelective(record);
    }

    @Override
    public Project selectByPrimaryKey(Integer itemid, String itemcode) {
        return projectMapper.selectByPrimaryKey(itemid, itemcode);
    }

    @Override
    public int updateByPrimaryKeySelective(Project record) {
        return projectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ProjectDto> selectproAll(String dataStatus, String userCode) {
        return projectMapper.selectproAll(dataStatus,userCode);
    }

    @Override
    public List<ProjectDto> selectchaAll(String dataStatus, String userCode) {
        return projectMapper.selectchaAll(dataStatus,userCode);
    }
}
