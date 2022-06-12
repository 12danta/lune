<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="userName" label="userName" width="120"> </el-table-column>
    <el-table-column label="Avatar" width="180">
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
    <el-table-column prop="Email" label="Email" width="200"></el-table-column>
    <el-table-column label="Registration Date" width="200">
      <template slot-scope="scope">{{ scope.row.date }}</template>
    </el-table-column>
    <el-table-column
      prop="tag"
      label="status"
      :filters="[{ text: 'user', value: 'user' }, { text: 'admin', value: 'admin' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.user_status === 'user' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.user_status}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column>
        <template slot="header" slot-scope="scope">
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
            title="user status"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
            <el-form ref="form" :model="form" label-width="100px">

            <el-form-item label="Status">
                <el-select v-model="form.region" placeholder="change the status">
                  <el-option label="Admin" value="Admin"></el-option>
                  <el-option label="User" value="User"></el-option>
                </el-select>
            </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">cancel</el-button>
              <el-button type="primary" @click="dialogVisible = false">confirm</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Del</el-button>
      </template>
    </el-table-column>
  </el-table>
  <div style="margin-top: 20px">
    <el-button @click="toggleSelection([tableData[1], tableData[2]])">切换第二、第三行的选中状态</el-button>
    <el-button @click="toggleSelection()">Cancel select</el-button>
  </div>

  </div>
</template>

<script>
export default {
  data () {
    return {
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
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      srcList: [
        'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
        'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
      ],
      tableData: [
        {
          date: '2016-05-03',
          userName: 'moonm',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        }
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
    handleClose (done) {
      this.$confirm('Are you sure to close ?')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    handleUpdatePic (index, row) {
      console.log(index, row)
    },
    onSubmit () {
      console.log('submit!')
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
