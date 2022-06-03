<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="albumName" label="Name" width="300"> </el-table-column>
    <el-table-column label="Pic" width="200">
        <template slot-scope="scope">
          <div class="demo-image__preview">
          <el-image
          style="width: 100px; height: 100px"
          :src="url"
          :preview-src-list="srcList">
        </el-image>
      </div>
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        multiple
        :limit="3"
        :on-exceed="handleExceed"
        :file-list="fileList">
      <el-tooltip placement="bottom" effect="light">
        <div slot="content">Only jpg/png files can be uploaded, <br/> and no more than 500kb</div>
        <el-button
              size="mini"
              type="warning"
              plain
              @click="handleUpdatePic(scope.$index, scope.row)">update</el-button>
      </el-tooltip>
      </el-upload>
        </template>
    </el-table-column>
    <el-table-column prop="albumReleaseTime" label="Release Time" width="300" ></el-table-column>
    <el-table-column prop="albumRecordLabel" label="Record Label" width="150" ></el-table-column>
    <el-table-column>
        <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row);dialogVisible = true">Edit</el-button>
          <el-dialog
            title="Album"
            :visible.sync="dialogVisible"
            width="60%"
            :before-close="handleClose">
            <el-form ref="form" :model="form" label-width="100px">
              <el-form-item label="Name">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="Composer">
                <el-input v-model="form.composer"></el-input>
              </el-form-item>
              <el-form-item label="Release Time">
                <template>
                  <div class="block">

                    <el-date-picker
                      v-model="value2"
                      align="right"
                      type="date"
                      placeholder="pick release time..."
                      :picker-options="pickerOptions">
                    </el-date-picker>
                  </div>
                </template>
              </el-form-item>
              <el-form-item label="Record Label">
                <el-input v-model="form.composer"></el-input>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">Cancel</el-button>
              <el-button type="primary" @click="dialogVisible = false">Confirm</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>
<script>
export default {
  data () {
    const generateData = _ => {
      const data = []
      const cities = ['上海', '北京', '广州', '深圳', '南京', '西安', '成都']
      const pinyin = ['shanghai', 'beijing', 'guangzhou', 'shenzhen', 'nanjing', 'xian', 'chengdu']
      cities.forEach((city, index) => {
        data.push({
          label: city,
          key: index,
          pinyin: pinyin[index]
        })
      })
      return data
    }
    return {
      data: generateData(),
      value: [],
      filterMethod (query, item) {
        return item.pinyin.indexOf(query) > -1
      },
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      dialogVisible: false,
      tagVisible: false,
      pickerOptions: {
        disabledDate (time) {
          return time.getTime() > Date.now()
        },
        shortcuts: [{
          text: '今天',
          onClick (picker) {
            picker.$emit('pick', new Date())
          }
        }, {
          text: '昨天',
          onClick (picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24)
            picker.$emit('pick', date)
          }
        }, {
          text: '一周前',
          onClick (picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', date)
          }
        }]
      },
      value1: '',
      value2: '',
      tableData: [
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        },
        {
          albumName: 'Higdon & Tchaikovsky: Violin Concertos',
          albumPic: 'pic',
          albumReleaseTime: '2010-01-01',
          albumRecordLabel: 'Deustche Grammophon'
        }
      ],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    },
    handleUpdatePic (index, row) {
      console.log(index, row)
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleClose (done) {
      this.$confirm('Are you sure to close it ?')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    handleTags (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}
</script>
<style scope>

</style>
