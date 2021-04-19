<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="信息描述">
        <el-tag type="info">excel模版说明</el-tag>
        <el-tag>
          <i class="el-icon-download"/>
          <a :href="OSS_PATH + '/online_teach_subject_template/importSubject_template.xlsx'">点击下载模版</a>
        </el-tag>

      </el-form-item>

      <el-form-item label="选择Excel">
        <el-upload
          ref="upload"
          :auto-upload="false"
          :on-success="fileUploadSuccess"
          :on-error="fileUploadError"
          :disabled="importBtnDisabled"
          :file-list="fileList"
          :limit="1"
          :action="BASE_API+'/serviceedu/edu-subject/addSubject'"
          name="file"
          :before-upload="beforeUpload"
          accept=".xls,.xlsx">
          <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
          <el-button
            :loading="loading"
            style="margin-left: 10px;"
            size="small"
            type="success"
            @click="submitUpload">{{ fileUploadBtnText }}</el-button>
        </el-upload>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'import',
  data() {
    return {
      BASE_API: process.env.BASE_API, // 接口API地址
      OSS_PATH: process.env.OSS_PATH, // 阿里云OSS地址
      fileUploadBtnText: '上传到服务器', // 按钮文字
      importBtnDisabled: false, // 按钮是否禁用,
      loading: false,
      fileList:[] //上传的文件列表
    }
  },
  methods: {
    submitUpload() {

      if (this.fileList.length<1) {
        this.$message({
          message: '请选择需要上传的excel文件',
          type: 'warning'
        });
        return
      }
      this.fileUploadBtnText = '正在上传'
      this.importBtnDisabled = true
      this.loading = true
      this.$refs.upload.submit()
    },

    fileUploadSuccess(response) {
      if (response.success === true) {
        this.fileUploadBtnText = '上传到服务器'
        this.loading = false
        this.importBtnDisabled = false
        this.$message({
          type: 'success',
          message: response.message
        })
      }
    },

    fileUploadError(response) {
      this.fileUploadBtnText = '上传到服务器'
      this.loading = false
      this.importBtnDisabled = false
      this.$message({
        type: 'error',
        message: '导入失败'
      })
    },
    beforeUpload(file) {

      console.log(file,"aaa")
      var testmsg=file.name.substring(file.name.lastIndexOf('.')+1)
      const extension = testmsg === 'xls'
      const extension2 = testmsg === 'xlsx'
      // const isLt2M = file.size / 1024 / 1024 < 10
      if(!extension && !extension2) {
        this.$message({
          message: '上传文件只能是 xls、xlsx格式!',
          type: 'warning'
        });
        this.fileUploadBtnText = '上传到服务器'
        this.loading = false
        this.importBtnDisabled = false
      }
      // if(!isLt2M) {
      //     this.$message({
      //         message: '上传文件大小不能超过 10MB!',
      //         type: 'warning'
      //     });
      // }
      // return extension || extension2 && isLt2M
      return extension || extension2
    },
  }
}
</script>

<style scoped>

</style>
